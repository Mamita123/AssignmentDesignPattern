import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('https://www.k-ruoka.fi/kauppa');
  await page.waitForLoadState('networkidle');

  // Accept cookies
  const acceptButton = await page.waitForSelector('button[data-testid="accept-cookies-button"]');
  await acceptButton.click();

  // Search for "olut" and add a product to the cart
  await page.click('input[placeholder="Hae kaupan valikoimasta"]');
  await page.fill('input[placeholder="Hae kaupan valikoimasta"]', 'olut');
  await page.waitForSelector('a[aria-label="Pirkka olut 4,5% 0,33l"]');
  await page.click('a[aria-label="Pirkka olut 4,5% 0,33l"]');
  await page.waitForSelector('[data-testid="product-details-sidebar"] [data-testid="add-to-basket-button"]');
  await page.click('[data-testid="product-details-sidebar"] [data-testid="add-to-basket-button"]');

  // Search for "makkara" and add a product to the cart
  await page.goto('https://www.k-ruoka.fi/kauppa/tuotehaku?haku=ollut');
  await page.click('input[placeholder="Hae kaupan valikoimasta"]');
  await page.fill('input[placeholder="Hae kaupan valikoimasta"]', 'makk');
  await page.waitForSelector('a[aria-label="Atria Hiillos Grillimakkara 400g"]');
  await page.click('a[aria-label="Atria Hiillos Grillimakkara 400g"]');
  await page.waitForSelector('[data-testid="product-details-sidebar"] [data-testid="add-to-basket-button"]');
  await page.click('[data-testid="product-details-sidebar"] [data-testid="add-to-basket-button"]');

  // Search for "juomat" and add a product to the cart
  await page.goto('https://www.k-ruoka.fi/kauppa/tuotehaku?haku=makkara');
  await page.click('input[placeholder="Hae kaupan valikoimasta"]');
  await page.fill('input[placeholder="Hae kaupan valikoimasta"]', 'juomat');
  await page.waitForSelector('a[aria-label="Coca-Cola Zero 0,33l 24-pack"]');
  await page.click('a[aria-label="Coca-Cola Zero 0,33l 24-pack"]');
  await page.waitForSelector('[data-testid="product-details-sidebar"] [data-testid="add-to-basket-button"]');
  await page.click('[data-testid="product-details-sidebar"] [data-testid="add-to-basket-button"]');
});
