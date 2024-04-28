import { test, expect } from '@playwright/test';


test('test', async ({ page }) => {
  await page.goto('https://www.k-ruoka.fi/');
  await page.goto('https://www.k-ruoka.fi/haku?q=ollut');
  await page.waitForTimeout(5000);
  await page.locator('text="Pirkka olut 4,5% 0,33l"').click({ timeout: 15000 });
  
  await page.getByRole('link', { name: 'Pirkka olut 4,5% 0,33l' }).click();
  
  // Expectation: Verify if the page URL contains the expected string
  expect(page.url()).toContain('https://www.k-ruoka.fi/');

  await page.getByPlaceholder('Hae tuotteita, kauppoja,').click();
  await page.getByPlaceholder('Hae tuotteita, kauppoja,').fill('makkara');
  await page.getByRole('link', { name: 'Atria Wilhelm Perinteinen 400g' }).click();
  
  // Expectation: Verify if the page URL contains the expected string
  expect(page.url()).toContain('https://www.k-ruoka.fi/');

  await page.getByTestId('product-details').click();
  await page.goto('https://www.k-ruoka.fi/haku?q=makkara');
  await page.getByPlaceholder('Hae tuotteita, kauppoja,').click();
  await page.getByPlaceholder('Hae tuotteita, kauppoja,').fill('juomat');
  await page.getByPlaceholder('Hae tuotteita, kauppoja,').press('Enter');
  await page.getByRole('link', { name: 'Coca-Cola Zero 0,33l 24-pack' }).click();
  
  // Expectation: Verify if the page URL contains the expected string
  expect(page.url()).toContain('https://www.k-ruoka.fi/');

  await page.getByTestId('product-main-image-container').click();
  await page.goto('https://www.k-ruoka.fi/haku?q=juomat');
  await page.getByRole('link', { name: 'Coca-Cola Zero 0,33l 24-pack' }).click();
  
  // Expectation: Verify if the page URL contains the expected string
  expect(page.url()).toContain('https://www.k-ruoka.fi/');

  await page.goto('https://www.k-ruoka.fi/haku?q=juomat');
  await page.getByRole('link', { name: 'Atria Wilhelm Perinteinen 400g' }).click();
  
  // Expectation: Verify if the page URL contains the expected string
  expect(page.url()).toContain('https://www.k-ruoka.fi/');

  await page.getByTestId('product-details-sidebar').getByTestId('add-to-basket-button').click();
  await page.getByRole('button', { name: 'Atria Wilhelm Perinteinen 400g' }).click();
  await page.getByLabel('Sulje tuotekuvat').click();
  await page.getByTestId('product-details-sidebar').getByTestId('increment-button').click();
});
