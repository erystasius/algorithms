package st

import scala.collection.mutable

class LRUCache(_capacity: Int)  {
  val hm = new mutable.HashMap[Int, Node]()
  val dl = new DoublyLinkedList

  def get(k: Int): Int = {
    hm.get(k) match {
      case Some(node) =>
        dl.moveHead(node)
        node.v
      case None => -1
    }
  }

  def put(k: Int, v: Int): Unit = {
    hm.get(k) match {
      case Some(hitNode) =>
        hitNode.v = v
        dl.moveHead(hitNode)
      case None =>
        val newNode = Node(k, v, null, null)
        hm.put(k, newNode)
        dl.add(newNode)
        if (dl.size > _capacity) {
          val lastNode = dl.popLast()
          hm.remove(lastNode.k)
        }
    }
  }

  class DoublyLinkedList {
    var size = 0
    var head: Node = Node(0, 0, null, null)
    var last: Node = Node(0, 0, null, null)
    head.next = last
    last.prev = head

    def add(node: Node): Unit = {
      node.prev = head
      node.next = head.next
      node.prev.next = node
      node.next.prev = node
      size = size + 1
    }

    def remove(node: Node): Unit = {
      node.prev.next = node.next
      node.next.prev = node.prev
      size = size - 1
    }

    def moveHead(node: Node): Unit = {
      remove(node)
      add(node)
    }

    def popLast(): Node = {
      val node = last.prev
      remove(node)
      node
    }
  }

  case class Node(var k: Int, var v: Int, var prev: Node, var next: Node)
}

object LRU {
  def main(args: Array[String]): Unit = {
    val cache = new LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1)) // 返回  1
    cache.put(3, 3) // 该操作会使得密钥 2 作废
    println(cache.get(2)) // 返回 -1 (未找到)
    cache.put(4, 4) // 该操作会使得密钥 1 作废
    println(cache.get(1)) // 返回 -1 (未找到)
    println(cache.get(3)) // 返回  3
    println(cache.get(4)) // 返回  4
  }
}
