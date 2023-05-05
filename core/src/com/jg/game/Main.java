package com.jg.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle egg;

	private Texture eggTexture;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();

		eggTexture = new Texture("eg.png");

		egg = new Rectangle();
		egg.x = 800 / 2 - 64 / 2;
		egg.y = 20;
		egg.width = 64;
		egg.height = 64;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.14901960784f, 0.14901960784f, 0.14901960784f, 1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			egg.x -= 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) egg.x += 200 * Gdx.graphics.getDeltaTime();


		if (egg.x < 0) egg.x = 0;
		if (egg.x > 800 - 64) egg.x = 800 - 64;

		batch.draw(eggTexture, egg.x, egg.y);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		eggTexture.dispose();
	}
}
