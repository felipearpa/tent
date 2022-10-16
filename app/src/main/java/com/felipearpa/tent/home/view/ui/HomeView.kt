package com.felipearpa.tent.home.view.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.felipearpa.core.emptyString
import com.felipearpa.tent.R
import com.felipearpa.tent.ui.theme.primaryDarker
import com.felipearpa.tent.ui.theme.primaryLight

private const val DEFAULT_SPACING = 8
private const val APP_TITLE_FONT_SIZE = 24
private const val POWERED_BY_FONT_SIZE = 12

@Composable
fun HomeView(viewModel: HomeViewModel) {
    HomeView(initialFilterText = viewModel.filterTextFlow.value, onFilterClick = viewModel::search)
}

@Composable
private fun HomeView(initialFilterText: String, onFilterClick: (String) -> Unit) {
    var filterText by remember { mutableStateOf(initialFilterText) }

    ConstraintLayout(
        modifier = Modifier
            .padding(all = DEFAULT_SPACING.dp)
            .fillMaxSize()
    ) {
        val (appTitleView, contentView, poweredByView) = createRefs()

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.constrainAs(appTitleView) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            },
            fontSize = APP_TITLE_FONT_SIZE.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryDarker
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp),
            modifier = Modifier.constrainAs(contentView) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }) {
            OutlinedTextField(
                value = filterText,
                onValueChange = { newText -> filterText = newText },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.search_placeholder))
                },
                singleLine = true
            )

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(onClick = { onFilterClick(filterText) }, enabled = filterText.isNotBlank()) {
                    Text(text = stringResource(id = R.string.search_action))
                }
            }
        }

        Text(
            text = stringResource(id = R.string.powered_by),
            modifier = Modifier.constrainAs(poweredByView) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            color = MaterialTheme.colors.primaryLight,
            fontStyle = FontStyle.Italic,
            fontSize = POWERED_BY_FONT_SIZE.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeViewPreview() {
    HomeView(initialFilterText = emptyString(), onFilterClick = {})
}