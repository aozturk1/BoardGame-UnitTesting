#Code Review Table
###Reviewer: Alper Ozturk
###GH Repo: ...

| ID#  | Location(File and Line Number)  |Problem Description   | Problem Category | Problem Severity |
|---|---|---|---|--|
| 1  | GamePlay.java Line 1  | Source code file missing a file and a public class banner.  | CG  | LOW |
| 2  | GamePlay.java Line 52  | Class name should be upper CamelCase, with first letter uppercase.  | CG  | LOW |
| 3  | GamePlay.java Line 53  | All complex statements must use explicit {} even if the body is a single line.  | CG  | LOW |
| 4  | GamePlay.java Line 137  | Duplicate code.  | CS  | LOW |
| 5  | GamePlay.java Line 211-222  | Program doesn't work correctly due to order of attack being always the same, no matter the opponent speed.  | FD  | MJ |
| 6  | GamePlay.java Line 7,157,158  | Unused variables.  | MD  | LOW |
| 7  | GamePlay.java Line 81  | Indentation should be consistent.  | CG  | LOW |

##Category: 
CS – Code Smell defect. CG – Violation of a coding guideline. Provide the guideline number. 
    FD – Functional defect. Code will not produce the expected result. MD – Miscellaneous defect, for all other defects.
##Severity: 
BR - Blocker, must be fixed asap. MJ – Major, of high importance but not a Blocker LOW – Low.
