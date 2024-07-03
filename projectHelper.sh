#!/bin/bash

# Prompt user for the folder name
read -p "Enter the folder name: " folder_name

# Convert the folder name to the desired format
formatted_folder_name=$(echo "$folder_name" | sed -E 's/^([0-9]+)\. /\1_/; s/ /_/g')

cd solutions || exit
# Create the folder
mkdir -p "$formatted_folder_name"

# Navigate to the folder
cd "$formatted_folder_name" || exit

# Create the required files
touch Solutions.java readme.md explanation.md

# Output the result
echo "Folder '$formatted_folder_name' created with Solutions.java, readme.md, and explanation.md files."
