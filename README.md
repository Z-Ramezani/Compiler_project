# Compiler_project
This repository contains the C compiler designed in java, as part of the Compiler Construction course at Isfahan University.

## Phases
This project consist of 3 phases:
* Lexical analyzer
* Syntax analyser
* Semantic analyser

## Lexical analyser
Categorizes the contents of the input file as tokens. It is also the job of lexical analyzer to get rid of code comments. The output of the lexical analyzer for our program for sample input would look like this:

Sample input
```
int main(){
int a=3;
float b=5;
int c=7;
int d=a+c;
for(int i=0;i<3;i++){
}

}
```
output

![output_lexical](https://user-images.githubusercontent.com/89459958/150696130-ceaada3a-77a2-4d55-a2e0-934e5430ad32.PNG)

For this part we used a DFA and it's table to tokenize the code. 
### Implementation of lexical analyser
Steps:
- [x] Create C Compiler DFA
- [x] Create C Compiler Table of DFA
- [x] Write java program of Lexical Analyser by using DFA
- [x] Add keywords and identifiers to Symbol Table 

## Syntax Analyser
In this part of our program we check if we can parse the input and create parse tree or there is a syntax error.

Sample input
```
int main(){
int a=3;
float b=5;
int c=7;
int d=a+c;
for(int i=0;i<3;i++){
}

}
```
output

![parse_tree](https://user-images.githubusercontent.com/89459958/150696232-ba6e92f3-58ca-41e2-ba32-931538992b9c.PNG)

### Implementation of syntax analyser
Steps:
- [x] Writing LL1 grammar for C language compiler
- [x] Create first and follow tables from grammar
- [x] Create LL1 parsing table using grammar and both first and follow tables
- [x] Writhe java progrma of syntax analyser by using parsing table and create parse tree.

## Semantic Analyser
After syntax analyser we use parse tree and a stack from matched tokens to create syntax tree.By using syntax tree we checked the type of identifiers and different types of data in operational statements.

Sample input
```
int main(){
int a=3.9;
float b=5.1;
int c=7;
int d=a+b;
for(int i=0;i<3;i++){
}

}
```
output
```
Semantic Error
Semantic Error
```
### Implementation of semantic analyser
Steps:
- [x] Create syntax tree
- [x] Check data types by finding the leave of the syntax tree and comparing their type.If in one oerational statement 2 or more different data types are found, the program prints Semantinc Error. (the types thet we check in this part are "int", "float", "double", "char")

## How to run this project
Create Lex(i).txt (i can be any number begins from 0) and copy Sample input or any input you want.run the java program and just select the folder where your different lex.txt files are.
For exmaple if you want to test 2 code you can create lex0.txt and lex1.txt and when you run the program choose the folder where you have saves these two files and it will check both of your files.

## Refrences
- [How to write your own C compiler from scratch with Python!](https://medium.com/@pasi_pyrro/how-to-write-your-own-c-compiler-from-scratch-with-python-90ab84ffe071#f6ed)

- Compilers Principles, Techniques, & Tools Seccond Edition

- https://www.javatpoint.com/java-jtree

