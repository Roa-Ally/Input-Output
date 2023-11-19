# Programming-2-Assignment-5
This is a program that converts a file format <br>
.csv into a .txt and vice versa <br>
<br>
use the provided .csv and .txt file to use this program <br>
No space in the .csv file and if a comma is part of a response put in double quotations <br>
<br>
Commands Implimentes: <br>
* convert source.xxx destination.yyy: this command converts source.xxx <br>
to destination.yyy where source.xxx is the name and extension of the file that user <br>
wants to convert and destination.yyy is the name and extension of the file in which <br>
the user wants to store the result of format conversion. Please note that xxx and yyy <br>
can either be csv or txt. Also, the file names may or may not include the path to the <br>
file in the file system. <br>

* normalize source.xxx: this command reads the content of source.xxx, <br>
 normalizes the content of each cell, and writes the normalized content back to the same <br>
 file. Normalizing a cell is an operation that depends on the current content of the cell: <br>
  * if cell is empty: writes N/A instead <br>
  * if cell contains an integer: normalization explicitly shows the sign (+ for positive and - for negative). Also, if the integer representation is shorter than 10 
   characters, it adds some leading zeros to make the representation 10 character 
   long. 
  * if cell contains a float/double: normalization shows two digit after decimal point. <br>
  Also, it uses scientific notation if the number is greater than 100 or less than 0.01. 
  * if cell contains a string longer than 13 characters, normalization shows the first 
   10 characters of the string followed by an ellipsis (three dots like this . . . )
    otherwise, normalization causes no change. <br>

 * quit ends the program <br>
