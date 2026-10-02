# Summarizer

[![codecov](https://codecov.io/gh/g-m-klosinski/java-streams/branch/main/graph/badge.svg)](https://codecov.io/gh/g-m-klosinski/java-streams)

*A sandbox created for practical testing of Streams API in Java 25.*

A tool that summarizes text by extracting nouns.

## Quick Start

Run the application and provide a text to summarize to standard input:

1. Prepare an input file `poem.txt` with the following contents:
   ```text
   Roses are red
   Violets are blue
   Sugar is sweet
   And so are you
   ```
   
1. Feed the file to input. For Bash:
   ```bash
   > mvn exec:java -q \
   > -Dexec.mainClass=gmklosinski.javastreams.Main \
   > < poem.txt 
   ```

1. You obtain `Roses Violets Sugar`