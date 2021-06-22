var mapFunction = function () {
	for (var i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance));
    }
	
};

var reduceFunction = function (id, srodki)
{

	return Array.sum(srodki);
};


printjson(
    db.people.mapReduce(
        mapFunction,
        reduceFunction,
        {
            out: { inline: 1 },
        })
);