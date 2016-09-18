# html-generator-edens-veden

Markdown to html generator created in an OOD class in Spring 2016. Partner project with Josh Veden. 
Below are the instructions for the program which can also be found in the `Main.java` file in the src folder. _Vedens Formatting CO._ is the fake name we made for our company that provides this service. 




<strong>_____VEDENS FORMATTING CO._____</strong><br>
Text to HTML formatting service

 Welcome Client! 

 This program allows you to pass in the name of the file you wish to format and formats the
 document using proper html syntax, overwriting the original file. We will place the appropriate html
 tags in your document, capturing nested levels of headers and lists, capturing empty lines and
 paragraphs, and capturing ordered(numbered) and unordered(bulleted) lists.

 Use the following instructions to provide us with a properly prepared document. If you do, you
 will get the HTML you want. If not, you might get something funky (like an error message or a
 messed up document).

<strong>RE: INPUT FILE FOR FORMATTING</strong><br>
 1. The name of a txt file (ending in .txt)
 1. A file that exists and is accessible from your computer
 <br>

<strong>RE: DOCUMENT MARKINGS</strong><br>
 1. <strong>Headers</strong> are denoted by any number of '#' in a row at the beginning of a line followed by a space. The number of '#' represents the level of nesting. You may skip levels if you wish. <br>
 ..........Examples: <br>
 .............# Header at level 1 <br>
 .............### Header at level 3 <br>

 2. <strong>Lists</strong> are either ordered(numbered) or unordered(bulleted). Ordered lists are denoted by any number of two spaces("  ") followed by '1.'. A level one ordered list line would have no spaces, level two would have two. Unordered lists are also denoted by quantity of space-pairs but a level one unordered list line would have 2 spaces and level two would have 4, and so on. If you give an odd number of spaces, the list item will be placed on the next higher level of nesting. (7 spaces would act the same as 6 spaces: level 4 nesting for ordered lists and level 3 for unordered). <br>
 ..........Examples: (I will use dashes to represent spaces for visual purposes) <br>
 .............1. OrderedList at level 1 <br> 
 .............----1. OrderedList at level 3 <br>
 .............--* UnorderedList at level 1 <br>
 .............----* UnorderedList at level 2 <br>


 If you do not follow these instructions, you won't get the result you want. Thanks for reading!

 Thank You for using Vedens Services for all your formatting needs!!
