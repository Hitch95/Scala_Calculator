object Calculator {
    def main(args: Array[String]): Unit = {
        println("Bienvenue sur la calculatrice scala")
        println("Entrez votre calcul sous la forme: nombre opérateur nombre")
        println("Exemple: 2 + 2")
        println("Tapez 'exit' pour quitter")

        // Boucle principale
        while (true) {
            val input = scala.io.StdIn.readLine()

            // Vérifier si le user veut quitter
            if (input.toLowerCase == "exit") {
                println("Au revoir !")
                System.exit(0)
            }

            try {
                // Découper l'entrée en parties
                val parts = input.split(" ")

                if (parts.length != 3) {
                    println("Format incorrect. \nVeuillez utiliser : nombre opérateur nombre")
                } else {
                    // Extraire les nombres de l'opérateur
                    val num1 = parts(0).toDouble
                    val operator = parts(1)
                    val num2 = parts(2).toDouble

                    // Effectuez le calcul
                    val result = operator match {
                        case "+" => num1 + num2
                        case "-" => num1 - num2
                        case "*" => num1 * num2
                        case "/" =>
                            if (num2 == 0) throw new ArithmeticException("Division par zero")
                            num1 / num2

                        case _ => throw new IllegalArgumentException("Operateur invalide")
                    }

                    // Afficher le résultat
                    println(s"Résultat: $result")
                }
            } catch {
                case e: NumberFormatException => 
                    println("Erreur: Veuillez entrer des nombres valides.")
                case e: ArithmeticException => 
                    println(s"Erreur: ${e.getMessage}")
                case e: IllegalArgumentException => 
                    println(s"Erreur: ${e.getMessage}")
                case _: Throwable => 
                    println("Une erreur inconnue s'est produite.")
            }

            println("\nEntrez un nouveau calcul ou tapez 'exit' pour quitter")
        }
    }
}
