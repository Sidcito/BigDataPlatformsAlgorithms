#!/usr/bin/python

import sys

# Dictionary of form {(word, docname): count]}
word_dictionary = {}

# Number of words per docname of the form {docname: wordsperdoc}
words_per_doc = {}

for line in sys.stdin:
    # Input of the form "docname	word count"
    docname, word_count = line.strip().split("\t")
    word, count = word_count.strip().split(" ")
    
    # Update the list of words and count
    if (word, docname) in word_dictionary.keys():
        # Increase the count of the current word
        word_dictionary[(word, docname)] += 1
    else:
        word_dictionary[(word, docname)] = 1
        
    # Print words per document
    for key in word_dictionary.keys():
        if key[1] in word_per_doc.keys():
            words_per_doc[key[1]] += 1
        else:
            words_per_doc[key[1]] = 1
            
    # Output of the form "word docname	count wordsperdoc"
    print "{0} {1}\t{2} {3}".format(word, docname, count, words_per_doc[docname])
