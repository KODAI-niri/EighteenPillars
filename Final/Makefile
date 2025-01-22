ANT	= env LC_ALL=ja_JP.UTF-8 ant
ARCHIVE	= $(shell basename `pwd`)
SHELLFILL = count_line
EXAMPLE = example

all:
	$(ANT) all

clean:
	$(ANT) clean

count:
	(cd $(EXAMPLE)/ ; ./$(SHELLFILL).sh ; )

test:
	$(ANT) test

install:
	$(ANT) install

doc:
	$(ANT) doc

wipe: clean
	@find . -name ".DS_Store" -exec rm {} ";" -exec echo rm -f {} ";"
	(cd ../ ; rm -f ./$(ARCHIVE).zip)

#zip:
#	$(ANT) zip

zip: wipe
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/ --exclude='*/.svn/*')
