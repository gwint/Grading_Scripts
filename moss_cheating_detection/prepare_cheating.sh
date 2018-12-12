mkdir ../cheating

for i in *; do
    if [ -d "$i" ]; then
        cd $i
	mkdir ../../cheating/$i
	cp flattened/* ../../cheating/$i
	cd ../
    fi
done
