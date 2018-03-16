#!/usr/bin/python
import sys

# Dictionary to store count and docname for each word
word_dictionary = {} # Of the form {word : [docname, count]}

# Read all key-value pairs from mapper_r1
for line in sys.stdin:

    # Get the word, docname and count from each line
    # input of form "word docname	1"
    word_docname, count = line.strip().split('\t')
    word, docname = word_docname.strip().split(' ') 

    # Ignoring path and extracting file name only (last element of path)
    docname= docname.split('/')[-1]
    
    # Updating the dictionary
    if word in word_dictionary.keys():
        word_dictionary[word][1] += 1
    else:
        word_dictionary[word] = [docname, 1]

for key in word_dictionary.keys():
    # Output of the form "word docname	count"
    print "{0} {1}\t{2}".format(key, word_dictionary[key][0], word_dictionary[key][1])
