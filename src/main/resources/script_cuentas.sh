#Primero damos de alta una nueva cuenta con un solo atributo (iban)
curl -X POST -H "Content-Type:application/json" -d '{"iban":"A321SD"}' 'http://localhost:8080/cuenta'

#Modificamos los atributos de la cuenta1 y añadimos los otros atributos
curl -i -X PUT -H "Content-Type:application/json" -d '{"iban":"A321S89QD", "titular":"David", "tipo":"cuentacorriente", "saldo":"50000"}' 'http://localhost:8080/cuenta/1'

#Damos de alta otra cuenta
curl -i -X POST -H "Content-Type:application/json" -d '{"iban":"FGSHS541", "titular":"Mouctar", "tipo":"cuentacorriente", "saldo":"5679121"}' 'http://localhost:8080/cuenta'


#Damos de alta una nueva cuenta
curl -i -X POST -H "Content-Type:application/json" -d '{"iban":"AHDBGDSYSD"}' 'http://localhost:8080/cuenta'

#Eliminamos la cuenta1, la 2 y la 3
curl -i -X DELETE 'http://localhost:8080/cuenta/1'
curl -i -X DELETE 'http://localhost:8080/cuenta/2'
curl -i -X DELETE 'http://localhost:8080/cuenta/3'

#Damos de alta un movimiento en la cuenta 1 y en la 2
curl -i -X POST -H "Content-Type:application/json" -d '{"concepto":"mouctar", "importe":"21.34", "saldoactual":"12345.65"}' 'http://localhost:8080/cuenta/1/movimientos'
curl -i -X POST -H "Content-Type:application/json" -d '{"concepto":"palomitas", "importe":"1221.64", "saldoactual":"15345.89"}' 'http://localhost:8080/cuenta/2/movimientos'