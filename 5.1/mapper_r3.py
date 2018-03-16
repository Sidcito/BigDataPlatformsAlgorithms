#!/usr/bin/python

import sys

# Input of the form "word,docname	count wordsperdoc"
for line in sys.stdin:
    worddocname, countwordsperdoc = line.rstrip().split('\t')
    word, docname = worddocname.split(" ")
    count, wordsperdoc = countwordsperdoc.split(" ")

        print "{0}\t{1} {2} {3}".format(word, docname, count, wordsperdoc)
	# Output of form "word	docname count wordsperdoc"
