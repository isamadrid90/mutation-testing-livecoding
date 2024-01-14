# Una historia de mutantes - Live coding

[![Software License][ico-license]][link-license]

# Gilded Rose Kata

## Introduction

Welcome to the Gilded Rose! We have a system in place that updates the inventory of items in our store. Your task is to improve the existing codebase to accommodate new item types and ensure the system remains maintainable.

## Instructions

1. The inventory system updates items at the end of each day.
2. Each item has a name, sell-in value, and quality value.
3. Items have specific rules for how their sell-in and quality values change.
4. Your goal is to add a new item type called "Conjured" and implement the necessary logic for it.

## Item Rules

- All items have a sell-in value, which denotes the number of days we have to sell the item.
- All items have a quality value, which denotes how valuable the item is.
- At the end of each day, the system lowers both values for every item.

### Common Item Rules

- Once the sell-in days reach 0, the quality degrades twice as fast.
- The quality of an item is never negative.
- "Aged Brie" increases in quality the older it gets.
- The quality of an item is never more than 50, except for "Sulfuras," which has a fixed quality of 80.

### Special Item Rules

- "Sulfuras" is a legendary item and never needs to be sold or decreases in quality.
- "Backstage passes" increases in quality as its sell-in value approaches. The quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less. The quality drops to 0 after the concert.
- "Conjured" items degrade in quality twice as fast as common items.

## Example

A quick example of the expected behavior:

- Aged Brie actually increases in quality the older it gets.
- "Sulfuras" never has to be sold and never decreases in quality.
- "Backstage passes" increases in quality as its sell-in value approaches; quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less, but quality drops to 0 after the concert.
- Once the sell-in days reach 0, the quality of an item degrades twice as fast.

## Notes

- Do not alter the `Item` class or the constructor signature.
- Feel free to make improvements to the existing codebase.
- Make sure the code is clean, maintainable, and easy to understand.
- If you find the existing code confusing, you can refactor it as needed.

Happy coding!


## License

The MIT License (MIT). Please see [License File][link-license] for more information.

[ico-license]: https://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square

[link-license]: LICENSE
[link-readme]: README.md
[link-gitignore]: .gitignore
[link-build-gradle]: build.gradle.kts
[link-author]: https://github.com/isamadrid90
