package jacode.com.br.agendavirtual.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import jacode.com.br.agendavirtual.Adapter.CommitmentAdapter;
import jacode.com.br.agendavirtual.Entidades.Commitment;
import jacode.com.br.agendavirtual.R;

public class PassadosFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CommitmentAdapter adapter;
    private List<Commitment> commitments;
    private DatabaseReference databaseReference;
    private Commitment commitment;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_passados, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        popularListaCompromisso();

        return  view;
    }
    private void popularListaCompromisso(){

        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        commitments = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("commitment").orderByChild("status").equalTo("Passado").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commitments.clear();

                for (DataSnapshot commitmentSnapshot : dataSnapshot.getChildren()){
                    commitment = commitmentSnapshot.getValue(Commitment.class);

                    commitments.add(commitment);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adapter = new CommitmentAdapter(commitments, getContext());

        mRecyclerView.setAdapter(adapter);

    }

}
