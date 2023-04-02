DinerDirector is a desktop productivity application used to manage the day-to-day operations of a restaurant. The user interacts it with a CLI and the program is written in Java which has just over 3 kLoC.

Code contributed: [RepoSense](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=Zeno-Zr&tabRepo=AY2223S2-CS2113-W15-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

Enhancements implemented: 

New feature: Added the ability to add dishes to a list of dishes 
- What it does: It allows the user to add information about a dish, which consists of: name of dish, price of dish, and a list of ingredients it is made up of. The dish is then updated into the list of dishes recorded in the program.
- Highlights: This feature requires parsing of multiple arguments. In paricular, it contains a need to store a list of ingredients, which is challenging to parse as it is a more complex data structure that can have a greater varied range of valid and invalid inputs to parse.

New feature: Added the ability to view all the dishes in the list of dishes currently stored.
- What it does: It prints to the console the dishes that are currently stored in the list in order.

New feature: Added the ability to delete a dish from the list using an index.
- What it does: It finds the dish to be deleted via the index given by the user of where the dish is located in the list of dishes.

New feature: Added the ability to find dishes containing a keyword in the list of dishes currently stored. 
- What it does: It allows the user to find dishes that contains a particular keyword.

Project Management:
- Managed `v2.0` release alongside [@darrenangwx](https://github.com/darrenangwx)

Contributions to the UG: 
- Added documentation for `add_dish`, `view_dish`, `delete_dish` and `find_dish`. [#70](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/70)
Contributions to the DG: Which sections did you contribute to the DG? Which UML diagrams did you add/updated?
- Added documentation & UML diagram for command component. [#62](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/62), [#70](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/70)
- Added documentation for Dish features and Sequence diagram for Add dish command. [#70](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/70)

Contributions to team-based tasks
- PRs reviewed (with non-trival comments): [#43](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/43), [#69](https://github.com/AY2223S2-CS2113-W15-4/tp/pull/69#partial-pull-merging)
- Reported bugs and suggestions for other teams (examples: [#4](https://github.com/Zeno-Zr/ped/issues/4), [#54](https://github.com/nus-cs2113-AY2223S2/tp/pull/54/files/98137b40bb81ba070f8cb2fbea7db1cadde0bc89#diff-1a95edf069a4136e9cb71bee758b0dc86996f6051f0d438ec2c424557de7160b))
