package com.example.presentation.engines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EnginesScreen(viewModel: EnginesViewModel) {
    LaunchedEffect(Unit) {
        viewModel.loadEngines()
    }
    val engines by viewModel.engines.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = "Список движков",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFFF9800),
            modifier = Modifier.padding(bottom = 24.dp)
        )
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(engines) { engine ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0B2))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = "id: ${engine.id}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "name: ${engine.name}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "title: ${engine.title}", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}