﻿# Changelog
All notable changes to this project will be documented in this file.

## [Unreleased]

## [2.1.0] - 2021-07-18
Released the same code to maven central repository. For dependencies versions updated.

## [2.0.0] - 20-10-20
Extension functions moved to different packages like for androidx.Fragment and support.Fragment - if they are in the same package compiler complaned for users.  
This is a breaking change means all users have to update imports. Nothing changed in behaviour.

## [1.1.0] - 2020-10-20
Bindings for custom View are searching in this view, not in rootView. This was a bug and it's a breaking changes, but I don't expect ppl to rely on this bug.

## [1.0.0] - 2020-04-11
The same as 0.4.4 - made release version

## [0.4.4] - 2020-04-11
Updated some google dependencies
Moved viewbinder functions to single package

## [0.4.1] - 2018-12-20
Fixed issue of uploading proper sources to jcenter (by updating jFrog gradle plugin)

## [0.4.0] - 2018-12-20
Added Adnroidx support

## [0.3.1]
- bintray upload changed - you'll get sources and javadocs in repository artifacts now
- Visibility of internal elements changed (I expect nobody used it so far)
- fixed leaking resettable in managed list

## [0.3.0] - 2017-12-11
- Breaking change: ResettableLazyManager renamed to BindingResetter
- findViewbyId changed to generics, I really expect that you are using build toold 26 and above
some cleanup
- library artifact changed from com.krenvpravo.viewbinder to com.viewbinder
- binding colors added

## [0.2.0] - 2017-11-01
Initial publishing of viewbinder
