# Darren Ang - Project Portfolio Page

## Overview
DinerDirector is a desktop productivity application used by restaurant managers to manage the day-to-day operations of a restaurant. The user interacts it with a CLI (command line interface) to manage their deadlines, meetings, dishes, and staffs in the restaurant. The program is written in Java, and has over 3 kLoC.

### Summary of Contributions

#### Code contributed: [Reposense](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=darrenangwx&breakdown=true&sort=groupTitle&sortWithin=title&since=2023-02-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=darrenangwx&tabRepo=AY2223S2-CS2113-W15-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)  

#### Enhancements implemented:  
* **New Feature**: Created the base skeleton of the project and the initial logic of how the program interacts with other components.
  * What it does: It includes the initial project layout of packages such as `commands`, `common`, `dinerdirector`, `exceptions`, `manager`, `ui`, `utils`. 
  * Justification: Allows my teammates to work on the features that they were assigned without thinking too much about how each feature will gel with one another.
* **New Feature**: Added initial logic for `DinerDirector`, `TextUi`, `Parser`.
  * What it does: `DinerDirector` is the main starting class for the program while `TextUi` and `Parser` is required for the interactions within the program.
  * Justification: Allows my teammates to use the `TextUi` and `Parser` template when it comes to implementing their individual commands.
* **New Feature**: Added `exit` command.
  * What it does: `exit` command allows the user to terminate the application successfully and gracefully.
  * Justification: This is a command required to allow the user to exit the application once they are done using it.
* **New Feature**: Added `help` command. 
  * What it does: `help` command allows the user to view a list of commands that are available to use within the application.
  * Justification: This command is required as it allow the user to view a list of commands that are available from within the application so that they won't be confused and second guess what commands are available to use in the application.
* **New Feature**: Added Storage feature for `deadlines`, `meetings`, `staff`, `dishes` 
  * What it does: Allows persistent storage of the data the user inputted across different sessions of the application.
  * Justification: This feature allows the user to store data in the application. Hence, the user would not have to retype what they typed previously into each of the list everytime the application starts itself up.

#### Documentation:
* Contributions to UG:
  * Added documentation for `help`, `exit`, `storage` feature [#75](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/75/files), [#93](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/93/files)
* Contributions to DG:
  * Added documentation for `Parser` and `Utils` feature [#51](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/51/files)
  * Added UML diagrams for `Parser` and `Utils` feature [#75](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/75/files)
  * Added User stories.

#### Project management and Contributions to team-based tasks:
* Managed the release of `v1.0`.
* Managed the release of `v2.0` alongside [@Zeno-Zr](https://github.com/Zeno-Zr).
* Track the project deadlines to ensure that the milestones are met and they are closed on time.
* Maintain the issue and pull requests to ensure that the issues are closed and the PR are merged in a timely manner.
* Ensure that the formatting in the UG and DG are well-aligned.
* PRs reviewed: [#23](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/23), [#25](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/25), [#29](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/29), [#32](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/32), [#39](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/39), [#44](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/44), [#59](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/59), [#62](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/62), [#64](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/64), [#67](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/67), [#77](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/77), [#90](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/90), [#92](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/92)

#### Beyond Project Team Tasks:
* Reported bugs and suggestions for other teams in PE-D: [PE-D Issues](https://github.com/darrenangwx/ped/issues)
* Reviewed other team's User Guide and Developer Guide.