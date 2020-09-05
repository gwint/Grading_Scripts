Hey guys, 

One of the other TA's has shown me how to use MOSS. You will need these scripts to make it work: 

Make sure to make them all executable using the chmod u+x command.

From there, the flatten_inside.sh script can be called on a directory containing all the submissions. The issue is that the directory will have a bunch of directories for each student. The flatten script will put all the files at the same directory level, by making the names of the files correspond to the original directory hierarchy. 

Let's say you have assignment04 unpacked by the unpack script I provided you with. 

Then running ./flatten_inside.sh assignment04 will take all the files in the directory and flatten them, in other words rename the files so that they include the old directory path in the file names, but put them all inside a flattened directory. After running, this flattened directory will be within the original assignment04 directory. 

The prepare_cheating.sh is optional, but basically it will create a nice clean folder that you can submit to MOSS. I did not look too deep into it as I found a way to get MOSS to work without needing it, which I describe below. 

I ran moss using the following command, keeping the flattened directory within assignment04:

./moss.pl -l java -d assignment04/flattened/*.java

The -l flag lets us specify which language the submissions were written in, and -d lets us tell it what directory to consider for files being similar. 

The MOSS script will then make sure all the files you have tried to include are text files. I had a weird case where a student's files had _userid_assignment04_._file.java, and the _._ made it not recognize those as text files. I had to manually go in and fix those names. Once that works, MOSS will log in and upload the files to the stanford server, check for commonalities, and then send you back a hyper link show casing the similarities. Here is an example, I ran on lab03 submissions:

http://moss.stanford.edu/results/365924538/

The higher the percentage, the more common the files are to one another. The page has a link describing how to interpret the calculated results. 

Please note the server takes a bit for it to send back the hyper link, so just give it a few minutes to process everything patiently. 

I am new to this myself, but would be more than happy to help you guys get MOSS working.
Please try to run it yourselves so that in the future we can all just start by checking submissions before continuing grading. 

If you find people cheating the first warning is a 0 for both parties. If the issue becomes persistent with a particular group of students, then we need to have a serious discussion with Professor Lander. 

Feel free to distribute the moss script to other TAs that need it, but don't post it publicly obviously. This freedom to distribute is mentioned in the MOSS script itself, which has handy usage cases. 

Regards,
Shawn 
