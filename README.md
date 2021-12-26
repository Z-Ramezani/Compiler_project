# Compiler_project
This repository contains the C compiler designed in java, as part of the Compiler Construction course at Isfahan University.

## Phases
This project consist of 3 phases:
* Lexical analyzer
* Syntax analyser
* Semantic analyser

## Lexical analyser
Categorizes the contents of the input file as tokens. It is also the job of lexical analyzer to get rid of code comments. The output of the lexical analyzer for our program would look like this:
input
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
- [x] Creat C Compiler DFA
- [x] Creat C Compiler Table of DFA
- [x] Write java program of Lexical Analyser by using DFA
- [x] Creat Symbol Table 




