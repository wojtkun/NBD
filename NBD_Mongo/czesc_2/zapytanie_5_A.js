printjson(db.people.aggregate([
{$match: {"sex":"Female","nationality": "Poland"}},
{$unwind:"$credit"},
{$group:{"_id":"$credit.currency", Suma_srodkow:{$sum:{$toDouble: "$credit.balance"}},Srednia_srodkow:{$avg:{$toDouble: "$credit.balance"}}}}
]));