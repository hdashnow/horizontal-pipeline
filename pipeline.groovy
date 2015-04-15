
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

make_manifest = {
  exec """
    ./make_mira_manifest.pl $input.fq ${input.fq.prefix}.manifest $input.fq.prefix
  """,local

}

assemble = {
    exec """
      phrap
    """
}

run {
    index_DB +
    "%_*.fastq.gz" * [ map_reads +
    extract_reads +
    assemble ]
}
