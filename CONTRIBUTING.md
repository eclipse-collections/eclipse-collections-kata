## Contributor License
If this is your first time contributing to an Eclipse Foundation project, you'll need to sign the [Eclipse Contributor Agreement][ECA].

- [Create an account](https://dev.eclipse.org/site_login/createaccount.php) on dev.eclipse.org
- Open your [Account Settings tab](https://dev.eclipse.org/site_login/myaccount.php#open_tab_accountsettings), enter your GitHub ID and click Update Account
- Read and [sign the ECA](https://dev.eclipse.org/site_login/myaccount.php#open_tab_cla)
- Use the exact same email address for your Eclipse account and your commit author.

## Issues
Search the [issue tracker](https://github.com/eclipse-collections/eclipse-collections-kata/issues) for a relevant issue or create a new one.
Comment on the issue expressing your interest to work on it. One of the project maintainers will assign the issue to you. 

## Making changes
* Fork the repository in GitHub and make changes in your fork. 
* Submit a pull request.

Details on [working with GitHub for Eclipse Collections](https://github.com/eclipse-collections/eclipse-collections/wiki/Working-with-GitHub) is located at the Eclipse Collections Wiki.

## Contact us
[Join the mailing list][mailing-list] and email the community at collections-dev@eclipse.org to discuss your ideas and get help.


## Coding Style
Eclipse Collections Kata follows a coding style that is similar to [Google's Style Guide for Java][style-guide], but with curly braces on their own lines. 

Avoid changing whitespace on lines that are unrelated to your pull request. This helps preserve the accuracy of the git blame view, and makes code reviews easier.

## Commit messages
- [Use the imperative mood][imperative-mood] as in "Fix bug" or "Add feature" rather than "Fixed bug" or "Added feature"
- [Mention the GitHub issue][github-issue] when relevant
- It's a good idea to follow the [advice in Pro Git](https://git-scm.com/book/ch5-2.html)

## Pull requests
Excessive branching and merging can make git history confusing. With that in mind

- Squash your commits down to a few commits, or one commit, before submitting a pull request
- [Rebase your pull request changes on top of the current master][rebase]. Pull requests shouldn't include merge commits.

Submit your pull request when ready. Three checks will be kicked off automatically.

- IP Validation: Checks that all committers signed the Eclipse CLA and signed their commits.
- Continuous integration: [GitHub Actions][github] that run JUnit tests.
- The standard GitHub check that the pull request has no conflicts with the base branch.

Make sure all the checks pass. One of the committers will take a look and provide feedback or merge your contribution.

That's it! Thanks for contributing to the Eclipse Collections Kata!

[ECA]:             https://www.eclipse.org/legal/ECA.php
[style-guide]:     https://google.github.io/styleguide/javaguide.html
[rebase]:          https://github.com/edx/edx-platform/wiki/How-to-Rebase-a-Pull-Request
[github]:          https://github.com/eclipse-collections/eclipse-collections/actions
[imperative-mood]: https://github.com/git/git/blob/master/Documentation/SubmittingPatches
[github-issue]:    https://help.github.com/articles/closing-issues-via-commit-messages/
[mailing-list]:    https://dev.eclipse.org/mailman/listinfo/collections-dev
