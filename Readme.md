# JSON A FICHERO

## Cómo guardar más de un objeto?

Esta operación puede ser realizada guardando los objetos en un ArrayList o Array
que serán serializados a JSON y escritos en un fichero mediante FileWriter.

Posteriormente parseados ayudandonos de guardarlos primeramente en una variable
de tipo String mediante FileReader, para ser parseada mediente gson apoyado con
Type y TypeToken para poder extender la información sobre el contenido del ArrayList.