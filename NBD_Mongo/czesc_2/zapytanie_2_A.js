printjson(db.people.aggregate([
{$unwind:"$credit"},
{$group:{"_id":"$credit.currency", Pozostale_srodki:{$sum:{$toDouble: "$credit.balance"}}}}
]))