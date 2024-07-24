#!/bin/bash

# Prompt user for the folder name
read -p "Enter the folder name: " folder_name

# Extract the number from the folder name using grep and sed
fetchednum=$(echo "$folder_name" | grep -o '^[0-9]\+' | sed 's/[^0-9]*//g')

if [ -z "$fetchednum" ]; then
  echo "Invalid input format. Please enter the input in the correct format (e.g., '2191. Sort the Jumbled Numbers')."
  exit 1
fi
# Convert the folder name to the desired format
formatted_folder_name=$(echo "$folder_name" | sed -E 's/^([0-9]+)\. /\1_/; s/ /_/g')

cd solutions || exit
# Create the folder
mkdir -p "$formatted_folder_name"

# Navigate to the folder
cd "$formatted_folder_name" || exit

# Create the required files
touch Solution.java readme.md explanation.md

# Output the result
echo "Folder '$formatted_folder_name' created with Solutions.java, readme.md, and explanation.md files."

# Append the extracted number to README.md in the desired format
echo "[$fetchednum]()" >> readme.md

echo "Appended [$fetchednum]() to README.md"