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
Output
```
keyword::int
keyword:: main
operator:: (
operator:: )
operator:: {
keyword:: int
identifier:: int
operator:: =
number:: 3
operator:: ;
keyword:: float
identifier:: float
number:: 5
```

For this part we used a DFA and it's table to tokenize the code. 
### Implementation of lexical analyser
Steps:
- [x] Create C Compiler DFA
- [x] Create C Compiler Table of DFA
- [x] Write java program of Lexical Analyser by using DFA
- [x] Add keywords and identifiers to Symbol Table 

## How to run this project
Create Lex.txt and copy Sample input or any iput you want.run the java program and just select where your Lex.txt is.
for exmaple if your text file is in Desktop you should select Desktop and click on Open button then you can see the result.

## Refrences
- [How to write your own C compiler from scratch with Python!](https://medium.com/@pasi_pyrro/how-to-write-your-own-c-compiler-from-scratch-with-python-90ab84ffe071#f6ed)

- Compilers Principles, Techniques, & Tools Seccond Edition


