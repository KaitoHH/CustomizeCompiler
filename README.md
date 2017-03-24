# Customize Compiler
Customize Compiler implements a statically strong typed language which compiles to Java. Its semantics is a subset of C but allows user-defined lexical and grammatical form by simply changing `lexer.json` and `production.json`.

#### some minor features
* an optional interpreter as an back-end
* jsonify/serialize abstract syntax tree
* print generated automata using Latex 
* generate Sublime syntax highlight configuration for user-defined lexical form
* interpret source code and show code coverage

# Customize lexical and grammatical form
There are two steps:
1. edit `lexer.json` to define lexical form (regular expression is supported)
2. edit `production.json` to define grammatical form (with a little limitation)
3. run `Grammar Factory` main method
  
There are three examples in [Syntax folder](https://github.com/KaitoHH/CustomizeCompiler/tree/master/Syntax) to show how to do this:
1. C++
2. Visual Basic
3. Frog :frog: (this is chinese programming language, mod is represented as '膜')

# Usage
Different arguments could be used to trigger different functionality:
```shell
>java Compiler -help
Usage: compiler [option]
Default:
FILE_NAME                      : compile FILE_NAME to AST
Option:
-exec AST_NAME                 : execute AST_NAME
-json JSON_FILE_NAME AST_NAME  : generate JSON format AST to JSON_FILE_NAME from AST_NAME
-showcoverage SOURCE_NAME      : show SOURCE_NAME code coverage
-tojava JAVA_NAME AST_NAME     : show java code to JAVA_NAME from AST_NAME
-repl                          : running REPL
-help                          : show this
...
```

## documentation
see [documentation.pdf](https://github.com/KaitoHH/CustomizeCompiler/blob/master/documentation_zhcn.pdf) for more information.

# Stack
* [JUnit](https://github.com/junit-team/junit4)
* [Cup](http://www2.cs.tum.edu/projects/cup/) - a LALR parser generator
