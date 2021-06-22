printjson(db.people.insertOne({
		"sex" : "Male",
		"first_name" : "Wojciech",
		"last_name" : "Kuna",
		"job" : "Data Scientist",
		"email" : "wkuna@google.co.uk",
		"location" : {
			"city" : "Warsaw",
			"address" : {
				"streetname" : "Marszałkowska",
				"streetnumber" : "123"
			}
		},
		"description" : "brak",
		"height" : "168",
		"weight" : "89",
		"birth_date" : "1994-05-23T13:34:58Z",
		"nationality" : "Poland",
		"credit" : [
			{
				"type" : "jcb",
				"number" : "1234567890",
				"currency" : "PLN",
				"balance" : "12345.86"

			}

		]

	}))