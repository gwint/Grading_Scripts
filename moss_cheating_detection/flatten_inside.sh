for i in *; do
    if [ -d "$i" ]; then
        cd $i
        files=$(find . -mindepth 1 -type f )
        mkdir flattened
        find . -mindepth 1 -type f -print0 | while IFS= read -r -d '' file; do
        unq=$(echo "$file"|sed -e "s/\//_/g"|sed -e "s/\//_/g" |cut -c 2-)
        unq=$(echo "$unq"|sed -e "s/[ ]/_/g"|sed -e "s/\//_/g")
        echo $unq
        cp "$file" "flattened/$unq"
    done

    cd ../
    fi
done