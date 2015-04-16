#!/usr/bin/env perl
use warnings;
use strict;

my $usage = "make_mira_manifest.pl left.fq right.fq outfile assembly_name\n";

#Writes a mira manifest file to outfile

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

print STDERR "Wrote mira manifest file for $project_name\n";
