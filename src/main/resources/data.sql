-- CATEGORIES DATAS
INSERT INTO `bookstore_db`.`categorie` (`libelle`) VALUES ('Informatique');
INSERT INTO `bookstore_db`.`categorie` (`libelle`) VALUES ('Biologie');
INSERT INTO `bookstore_db`.`categorie` (`libelle`) VALUES ('Couture');
INSERT INTO `bookstore_db`.`categorie` (`libelle`) VALUES ('Roman');
INSERT INTO `bookstore_db`.`categorie` (`libelle`) VALUES ('Cuisine');

-- ROLES DATAS
INSERT INTO `bookstore_db`.`roles` (`id`, `libelle`) VALUES ('1', 'ADMIN');
INSERT INTO `bookstore_db`.`roles` (`id`, `libelle`) VALUES ('2', 'CLIENT');
INSERT INTO `bookstore_db`.`roles` (`id`, `libelle`) VALUES ('3', 'EDITOR');

-- CATEGORIE SOCIO PROF DATAS
INSERT INTO `bookstore_db`.`cat_socio_prof` (`libelle`) VALUES ('Policier');
INSERT INTO `bookstore_db`.`cat_socio_prof` (`libelle`) VALUES ('DBA');
INSERT INTO `bookstore_db`.`cat_socio_prof` (`libelle`) VALUES ('Developpeur');
INSERT INTO `bookstore_db`.`cat_socio_prof` (`libelle`) VALUES ('Journaliste');

-- DEVISE DATAS
INSERT INTO `bookstore_db`.`devises` (`code`, `libelle`) VALUES ('$', 'Dollar');
INSERT INTO `bookstore_db`.`devises` (`code`, `libelle`) VALUES ('£', 'Livre');
INSERT INTO `bookstore_db`.`devises` (`code`, `libelle`) VALUES ('€', 'Euro');
INSERT INTO `bookstore_db`.`devises` (`code`, `libelle`) VALUES ('XOF', 'FCFA');


-- USERS DATAS
INSERT INTO `bookstore_db`.`utilisateurs` (`active`, `addresse`, `civilite`, `date_naissance`,
`email`, `nationnalite`, `nom`, `password`, `prenom`, `telephone`,`cat_socio_prof_id`, `role_id`)
  VALUES (1, '23 eme Rue de la soire', 'Mr', '1990-09-08 00:00:00', 'asjohnfrancis@gmail.com',
   'Benin', 'ASSOGBA', '$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG', 'Francois',
    '+22968955255', 1, 1);

INSERT INTO `bookstore_db`.`utilisateurs` (`active`, `addresse`, `civilite`, `date_naissance`,
`email`, `nationnalite`, `nom`, `password`, `prenom`, `telephone`, `cat_socio_prof_id`, `role_id`)
  VALUES (1, 'Avenue Steimetz', 'Madame', '1998-05-08 00:00:00', 'mongo@mal.io', 'Tcheque',
  'TOKILOVA', '$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi', 'Emanuella',
  '+2296544585', 2, 2);

INSERT INTO `bookstore_db`.`utilisateurs` (`active`, `addresse`, `civilite`, `date_naissance`,
`email`, `nationnalite`, `nom`, `password`, `prenom`, `telephone`, `cat_socio_prof_id`, `role_id`)
  VALUES (1, 'Bombier de gare', 'Monsieur', '1980-02-01 00:00:00', 'leblanco@mail.fr', 'France',
  'LEBLANC', '$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi', 'Albert',
  '+22968955255', 3, 3);

-- OUVRAGE DATA

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre sans precedant. Plein de recette africain, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Mon petit livre des recettes', '5', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un roman sans precedant. Plein de recette africain, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'La tete du chat gris', '4', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre infomatique sans precedant. Plein de code, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Master PHP quickly', '1', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre infomatique sans precedant. Plein de code, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Livre 4 du catalogue', '1', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre infomatique sans precedant. Plein de code, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Livre 5 du catalogue', '1', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre infomatique sans precedant. Plein de code, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Livre 6 du catalogue', '1', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre infomatique sans precedant. Plein de code, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Livre 7 du catalogue', '1', '4');

INSERT INTO `bookstore_db`.`ouvrage` (`date_parution`, `date_publication`, `description`, `isbn`,
`lien`, `photo`, `prix_unitaire`, `titre`, `categorie_id`, `devise_id`)
VALUES ('1990-09-08 00:00:00', '1990-09-08 00:00:00', 'Un livre infomatique sans precedant. Plein de code, vous trouverez.',
'5488CSAD8VCASDC84DA4', 'book', 'mon_petit_livre_des_recettes.jpg', '2500',
'Livre 8 du catalogue', '1', '4');

