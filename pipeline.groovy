
run {
    index_DB +
    "%_*.fastq.gz" * [ map_reads +
    extract_reads +
    assemble ]
}
