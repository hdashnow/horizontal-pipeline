#!/usr/bin/env perl
use warnings;
use strict;

my $usage = "make_mira_manifest.pl left.fq right.fq outfile.txt assembly_name\n";

my $leftfile = $ARGV[0];
my $rightfile = $ARGV[1];
my $outfile = $ARGV[2];
my $project_name = $ARGV[3];

unless( open OUT, ">$outfile"){die "Couldn't open $outfile for writing\n$!";}

print OUT "
# Manifest describing a denovo assembly with
# one library of paired reads

project = $project_name
job = genome,denovo,accurate
readgroup = DataIlluminaPairedLib
autopairing
data = $leftfile $rightfile
technology = solexa\n";

print STDERR "Written mira manifest file for $project_name\n";
