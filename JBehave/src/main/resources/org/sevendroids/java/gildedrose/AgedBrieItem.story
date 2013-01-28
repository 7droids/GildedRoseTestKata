Given is a Aged Brie item with sellin = 2 and quality = 49
When I update the item
Then sellin = 1 and quality = 50

When I update the item
Then sellin = 0 and quality = 50

When I update the item
Then sellin = -1 and quality = 50

Given is a Aged Brie item with sellin = 0 and quality = 40
When I update the item
Then sellin = -1 and quality = 42
