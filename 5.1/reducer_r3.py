#!/usr/bin/python

import sys
import numpy as np

word_dictionary = {}
docs_pword = {}  # To count docs per word.Of the form {word : docsperword}
doclist = []  # To store the names and count the documents
final_dictionary = {}

# Fill the dictionary
for line in sys.stdin:
    # Input of form "word	docname count wordsperdoc"
    word, value = line.split("\t")
   docname, count, wordsperdoc = value.split(" ")
    
    # {(word, docname) : [count, wordsperdoc, docsperword]}
    word_dictionary[(word, docname)] = [count, wordsperdoc, 0]
    
    # Check if the word has been seen before
    if docs_pword[word]:
        docs_pword[word] += 1
    else:
        docs_pword[word] = 1

# Making a list of all the different documents      
for key in word_dictionary.keys():
    if key[1] not in doclist:
        doclist.append(key[1])
    else:
        continue
        
# Print final output (tfidf) of form "word docname tfidf" on a new line
for key in word_dictionary.keys():
    
    # word count / words per doc
    arg1 = ( word_dictionary[key][0] / word_dictionary[key][1])
    # log(number of docs / docs per word)
    arg2 = np.log(len(doclist) / docs_pword[word])
    
    final_dictionary[(word_dictionary[key[0]], word_dictionary[key[1]])] = arg1 * arg2
    
    sorted_dictionary = sorted(final_dictionary, reverse = True)[:20]
    
for key in sorted_dictionary:
    print"{0} {1} {2}'\n'".format(key[0],key[1],sorted_dictionary[key])
    # Output of the form "word docname tfidf"
    

    
    
    
