
index_DB = {
    exec """
        bowtie2-build $input.fasta $output.fasta.prefix
    """
}

map_reads = {
    exec """
       /vlsci/VR0002/shared/hdashnow 
    """
}

extract_reads = {
    exec """
    """
}

assemble = {
    exec """
    """
}

run {
    index_DB +
    "%_*.fastq.gz" * [ map_reads +
    extract_reads +
    assemble ]
}
