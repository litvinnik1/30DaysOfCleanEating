package com.example.thirty_days_of_clean_eating

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirty_days_of_clean_eating.model.Dish
import com.example.thirty_days_of_clean_eating.ui.theme.DishesTheme


@Composable
fun DishesItem(
    dish: Dish,
    modifier: Modifier = Modifier
) {
    DishesListItem(dish.dishNumber, dish.dishName,dish.dishImage,dish.dishDescription)
}
@Composable
fun DishesListItem(
    @StringRes dishNumber:Int,
    @StringRes dishName:Int,
    @DrawableRes dishImage:Int,
    @StringRes dishDescription: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = modifier
                    .padding(16.dp)
            ) {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(dishNumber),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(R.string.of_30),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(Modifier.width(20.dp))
                Text(
                    text = stringResource(dishName),
                    style = MaterialTheme.typography.displayMedium
                )
            }
            Image(
                painter = painterResource(dishImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        DishesItemButton(
            expanded = expanded,
            onClick = { expanded = !expanded },
        )
        if (expanded) {
            DishesDescription(
                dishDescription,
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
            )
        }
    }
}
@Composable
private fun DishesItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if(expanded ) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            contentDescription = "See more or less information about a dish",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}
@Composable
fun DishesDescription(
    @StringRes dishDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.dish_about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(dishDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun DishesPreview() {
    DishesTheme {
    }
}