package org.d3ifcool.careservice.firebase.SosDb

import androidx.lifecycle.LiveData
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.getValue
import org.d3ifcool.careservice.firebase.ArtikelDb.ArtikelEntities

class SosLiveData (private val db: DatabaseReference): LiveData<List<SosEntities>>() {

    private val data = ArrayList<SosEntities>()

    init{
        value = data.toList()
    }

    private val listener = object: ChildEventListener {

        override fun onCancelled(error: DatabaseError) { }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) { }

        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            val sos = snapshot.getValue<SosEntities>() ?: return
            sos.id = snapshot.key ?: return

            val pos = data.indexOfFirst { it.id == sos.id }
            data[pos] = sos
            value = data.toList()
        }

        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val sos = snapshot.getValue<SosEntities>() ?: return
            sos.id = snapshot.key ?: return

            data.add(sos)
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