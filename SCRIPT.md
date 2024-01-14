- Intro explicando la historia del codigo legacy 10
- Explicar qué es mutation testing, mutant, survived and killed 20
- Empezariamos con un código de base, quizá con un minimo de test,
con una pipeline ya existente en github actions.
- Explicar como se configura pitest y cómo se ejecuta 5
- Ejecutar y ver los informes 5
- Elegir 3-5 mutantes distintos y añadir tests para capturar a cada mutante 30
  - changed conditional boundary → SURVIVED (condicionales en la actualización de quality)
  este es muy interesante porque hay que tener en cuenta que la quality se calcula después de actualizar el sellIn, por lo que necesitas un test que vaya a poner el sellIn a 0
  - Replaced integer addition with subtraction → NO_COVERAGE (actualizar quality del age cuando el sellIn pasa a negativo)
  - removed call to com/isamadrid90/demo/Item::setQuality → NO_COVERAGE (actualizar la quality del backstage que no tendrá test)
  - replaced int return with 0 for com/isamadrid90/demo/GildedRose::updateQualityAgedBrie → KILLED

- Añadir mutation testing al pipeline 10
