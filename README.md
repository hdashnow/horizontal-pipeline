# horizontal-pipeline

## Useful links:

Bpipe http://docs.bpipe.org/

Mira http://mira-assembler.sourceforge.net/docs/DefinitiveGuideToMIRA.html


Running it on Merri, here: /vlsci/VR0002/shared/hdashnow

## To run the pipeline

Assuming you have made and are in the horizontal-pipeline/analysis folder:

bpipe run ../pipeline.groovy ../IS.fna ../../simulations/*.fastq


## Switching over to using Focused-iterative-de-novo-assembler

https://github.com/rrwick/Focused-iterative-de-novo-assembler


To run a pair of reads against all the database at once:

bpipe run ../iterative_pipeline_all.groovy 


To run a pair of reads against all of the database, but one IS at a time (run in parallel):

bpipe run -n 4 ../iterative_pipeline.groovy individual_fasta/*.fa
