#Primero damos de alta una nueva cuenta con un solo atributo (iban)
curl -X POST -H "Content-Type:application/json" -d '{"iban":"A321SD"}' 'http://localhost:8080/cuenta'

#Modificamos los atributos de la cuenta1 y añadimos los otros atributos
curl -i -X PUT -H "Content-Type:application/json" -d '{"idcuenta":"1004", "iban":"A321S89QD", "titular":"David", "tipo":"cuentacorriente", "saldo":"50000"}' 'http://localhost:8080/cuenta/1'

#Modificamos únicamente el parámetro tipo de la cuenta1
curl -i -X PATCH -H "Content-Type:application/json" -d '{"tipo":"plandepensiones"}' 'http://localhost:8080/cuenta/1'

#Damos de alta otra cuenta
curl -i -X POST -H "Content-Type:application/json" -d '{"idcuenta":"2004", "iban":"FGSHS541", "titular":"Mouctar", "tipo":"cuentacorriente", "saldo":"5679121"}' 'http://localhost:8080/cuenta'

#Listamos todas las cuentas que tenemos
curl -X GET 'http://localhost:8080/cuenta'

#Damos de alta una nueva cuenta
curl -i -X POST -H "Content-Type:application/json" -d '{"iban":"AHDBGDSYSD"}' 'http://localhost:8080/cuenta'

#Eliminamos la cuenta3
curl -i -X DELETE 'http://localhost:8080/cuenta/3'

#Buscamos una cuenta por titular, en este caso Mouctar
curl http://localhost:8080/cuenta/search/findByTitular?titular=Mouctar