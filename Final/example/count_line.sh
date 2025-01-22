#! /bin/sh

total_lines=0

pillar_directory="pillars"

cc_directory="cc"

files=$(find . -name '*.java')

for file in ${files}
do
    if [ -f "$file" ]; then
        lines=$(wc -l < "$file")
        echo "$file $lines"
        total_lines=$((total_lines + lines))
    fi
done

echo "total_lines $total_lines"
