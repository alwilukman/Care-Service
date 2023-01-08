package org.d3ifcool.careservice.firebase.dealer

import androidx.lifecycle.LiveData
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.getValue

class DealerLiveData  (private val db: DatabaseReference): LiveData<List<DealerEntities>>() {

    private val data = ArrayList<DealerEntities>()

    init{
        value = data.toList()
    }

    private val listener = object: ChildEventListener {

        override fun onCancelled(error: DatabaseError) { }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) { }

        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            val dealer = snapshot.getValue<DealerEntities>() ?: return
            dealer.id = snapshot.key ?: return

            val pos = data.indexOfFirst { it.id == dealer.id }
            data[pos] = dealer
            value = data.toList()
        }

        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val dealer = snapshot.getValue<DealerEntities>() ?: return
            dealer.id = snapshot.key ?: return

            data.add(dealer)
            value = data.toList()
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            val id = snapshot.key ?: return
            val pos = data.indexOfFirst { it.id == id }

            data.removeAt(pos)
            value = data.toList()
        }
    }

    override fun onActive() {
        db.addChildEventListener(listener)
    }

    override fun onInactive() {
        db.removeEventListener(listener)
        data.clear()
    }
}