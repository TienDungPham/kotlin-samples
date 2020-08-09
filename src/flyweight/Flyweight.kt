package flyweight

object TreeFactory {
    private val collectionOfTreeType = hashMapOf<String, TreeType>()

    fun getTreeType(name: String, color: String): TreeType {
        var treeType = collectionOfTreeType["$name$color"]
        if (treeType == null) {
            collectionOfTreeType["$name$color"] = TreeType(name, color)
            treeType = collectionOfTreeType["$name$color"]
        }
        return treeType as TreeType
    }
}

class TreeType(val name: String, val color: String)

class Tree(val x: Int, val y: Int, val treeType: TreeType)

class Forest {
    val collectionOfTree = arrayListOf<Tree>()

    fun plantTree(x: Int, y: Int, name: String, color: String) {
        collectionOfTree.add(Tree(x, y, TreeFactory.getTreeType(name, color)))
    }
}

fun main() {
    val forest = Forest();
    forest.plantTree(1, 1, "Pine", "Red")
    print("${forest.collectionOfTree[0].treeType} - ")
    forest.plantTree(1, 2, "Pine", "Red")
    print("${forest.collectionOfTree[1].treeType} - ")

    forest.plantTree(1, 3, "Pine", "Blue")
    print("${forest.collectionOfTree[2].treeType} - ")
}