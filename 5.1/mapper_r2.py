#!/usr/bin/python

import sys

for line in sys.stdin:
    # Input of the form "word docname	count"
    word, docname_count = line.strip().split(" ")
    docname, count = docname_count.strip().split("\t")
    
    # Output of the form "docname	word count"
    print"{0}\t{1} {2}".format(docname, word, count)
