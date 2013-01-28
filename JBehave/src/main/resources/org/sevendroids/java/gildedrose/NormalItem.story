Given is a normal item with sellin = 1 and quality = 5
When I update the item
Then sellin = 0 and quality = 4

When I update the item
Then sellin = -1 and quality = 2

When I update the item
Then sellin = -2 and quality = 0

When I update the item
Then sellin = -3 and quality = 0
